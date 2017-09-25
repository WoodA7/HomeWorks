package instances;

import java.sql.Date;

public class Declaration {

    private int id;
    private Company company;
    private Status status;
    private Date date;

    public void setId(int id) {
        this.id = id;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public Status getStatus() {
        return status;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
