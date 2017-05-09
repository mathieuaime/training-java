package com.excilys.computerdatabase.services.interfaces;

import java.util.List;

import com.excilys.computerdatabase.dtos.CompanyDTO;
import com.excilys.computerdatabase.dtos.ComputerDTO;
import com.excilys.computerdatabase.exceptions.CompanyNotFoundException;

public interface CompanyService {

    /**
     * Returns the list of the companies.
     * @return List CompanyDTO
     */
    List<CompanyDTO> get();

    /**
     * Returns the company id.
     * @param id the id of the company
     * @return CompanyDTO
     */
    CompanyDTO getById(long id);

    /**
     * Returns the list of companies named name.
     * @param name the name of the company
     * @return List CompanyDTO
     */
    List<CompanyDTO> getByName(String name);

    /**
     * Returns the list of the computers of the company id.
     * @param id the id of the company
     * @return List ComputerDTO
     */
    List<ComputerDTO> getComputers(long id);

    /**
     * Delete the company id and all its computers.
     * @param id the id of the company
     * @throws CompanyNotFoundException when the company does not exist
     */
    void delete(long id) throws CompanyNotFoundException;
}
