package com.excilys.computerdatabase.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.excilys.computerdatabase.config.Config;
public class Computer {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(Config.getProperties().getProperty("date_format"));

    private long id;
    private String name;
    private LocalDate introduced;
    private LocalDate discontinued;
    private Company company;

    /**
     * Computer private constructor.
     * @param name name
     */
    public Computer(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getIntroduced() {
        return introduced;
    }

    public void setIntroduced(LocalDate introduced) {
        this.introduced = introduced;
    }

    public LocalDate getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(LocalDate discontinued) {
        this.discontinued = discontinued;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public static class Builder {

        private Computer computer;

        /**
         * Builder constructor.
         * @param name name
         */
        public Builder(String name) {
            computer = new Computer(name);
        }

        /**
         * Add an id.
         * @param id id
         * @return Builder
         */
        public Builder id(long id) {
            computer.id = id;
            return this;
        }

        /**
         * Add an introduced date.
         * @param introduced introduced date
         * @return Builder
         */
        public Builder introduced(LocalDate introduced) {
            computer.introduced = introduced;
            return this;
        }

        /**
         * Add a discontinued date.
         * @param discontinued discontinued date
         * @return Builder
         */
        public Builder discontinued(LocalDate discontinued) {
            computer.discontinued = discontinued;
            return this;
        }

        /**
         * Add a company.
         * @param company company
         * @return Builder
         */
        public Builder company(Company company) {
            computer.company = company;
            return this;
        }

        /**
         * Build the Company.
         * @return Computer
         */
        public Computer build() {
            return computer;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((company == null) ? 0 : company.hashCode());
        result = prime * result + ((discontinued == null) ? 0 : discontinued.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((introduced == null) ? 0 : introduced.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Computer other = (Computer) obj;
        if (company == null) {
            if (other.company != null) {
                return false;
            }
        } else if (!company.equals(other.company)) {
            return false;
        }
        if (discontinued == null) {
            if (other.discontinued != null) {
                return false;
            }
        } else if (!discontinued.equals(other.discontinued)) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (introduced == null) {
            if (other.introduced != null) {
                return false;
            }
        } else if (!introduced.equals(other.introduced)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return id + "/"
                + name + "/"
                + (introduced != null ? introduced.format(DATE_FORMATTER) : "") + "/"
                + (discontinued != null ? discontinued.format(DATE_FORMATTER) : "") + "/"
                + company;
    }
}
