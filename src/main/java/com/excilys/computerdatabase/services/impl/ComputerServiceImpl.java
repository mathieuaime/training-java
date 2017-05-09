package com.excilys.computerdatabase.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.excilys.computerdatabase.daos.ConnectionMySQL;
import com.excilys.computerdatabase.daos.impl.ComputerDAOImpl;
import com.excilys.computerdatabase.dtos.CompanyDTO;
import com.excilys.computerdatabase.dtos.ComputerDTO;
import com.excilys.computerdatabase.dtos.Page;
import com.excilys.computerdatabase.exceptions.ComputerNotFoundException;
import com.excilys.computerdatabase.mappers.CompanyMapper;
import com.excilys.computerdatabase.mappers.ComputerMapper;
import com.excilys.computerdatabase.models.Computer;
import com.excilys.computerdatabase.services.interfaces.ComputerService;
import com.excilys.computerdatabase.services.interfaces.PageService;

public enum ComputerServiceImpl implements ComputerService, PageService<ComputerDTO> {

    INSTANCE;

    private ComputerDAOImpl computerDAO = ComputerDAOImpl.INSTANCE;

    @Override
    public List<ComputerDTO> get() {
        return getPage().getObjects();
    }

    @Override
    public Page<ComputerDTO> getPage() {
        return getPage(1, count(null), null, null, null);
    }

    @Override
    public Page<ComputerDTO> getPage(int pageNumero, int length) {
        return getPage(pageNumero, length, null, "name", "ASC");
    }

    @Override
    public Page<ComputerDTO> getPage(int pageNumero, int length, String search, String column, String order) {
        ConnectionMySQL.open();
        Page<ComputerDTO> p = new Page<ComputerDTO>(
                computerDAO.findAll((pageNumero - 1) * length, length, search, column, order).stream()
                        .map(it -> ComputerMapper.createDTO(it)).collect(Collectors.toList()),
                pageNumero);
        ConnectionMySQL.close();

        return p;
    }

    @Override
    public ComputerDTO getById(long id) throws ComputerNotFoundException {
        ConnectionMySQL.open();
        Computer computer = computerDAO.getById(id);
        ConnectionMySQL.close();

        if (computer == null) {
            throw new ComputerNotFoundException("Computer Not Found");
        }

        return ComputerMapper.createDTO(computer);
    }

    @Override
    public List<ComputerDTO> getByName(String name) {
        ConnectionMySQL.open();
        List<ComputerDTO> l = computerDAO.getByName(name).stream().map(it -> ComputerMapper.createDTO(it))
                .collect(Collectors.toList());
        ConnectionMySQL.close();

        return l;
    }

    @Override
    public ComputerDTO add(Computer computer) {
        ConnectionMySQL.open();
        ComputerDTO c = ComputerMapper.createDTO(computerDAO.add(computer));
        ConnectionMySQL.close();

        return c;
    }

    @Override
    public void update(Computer computer) throws ComputerNotFoundException {
        ConnectionMySQL.open();
        computerDAO.update(computer);
        ConnectionMySQL.close();
    }

    @Override
    public void delete(long id) throws ComputerNotFoundException {
        ConnectionMySQL.open();
        computerDAO.delete(id);
        ConnectionMySQL.close();
    }

    @Override
    public void delete(List<Long> ids) throws ComputerNotFoundException {
        ConnectionMySQL.open();
        computerDAO.delete(ids);
        ConnectionMySQL.close();
    }

    @Override
    public int count(String search) {
        ConnectionMySQL.open();
        int c = computerDAO.count(search);
        ConnectionMySQL.close();

        return c;
    }

    @Override
    public CompanyDTO getCompany(long id) {
        ConnectionMySQL.open();
        CompanyDTO c = CompanyMapper.createDTO(computerDAO.getCompany(id));
        ConnectionMySQL.close();

        return c;
    }
}
