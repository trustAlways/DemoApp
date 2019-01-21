package tabview.nested.demo.com.demoapp.modelfile;

public class Company
{
    String company_id ;
    String company_name;
    String company_networth;
    int company_photo;

    public Company(String company_id, String company_name, String company_networth, int company_photo) {
        this.company_id = company_id;
        this.company_name = company_name;
        this.company_networth = company_networth;
        this.company_photo = company_photo;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_networth() {
        return company_networth;
    }

    public void setCompany_networth(String company_networth) {
        this.company_networth = company_networth;
    }

    public int getCompany_photo() {
        return company_photo;
    }

    public void setCompany_photo(int company_photo) {
        this.company_photo = company_photo;
    }
}
