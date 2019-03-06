package tabview.nested.demo.com.demoapp.modelfile;

public class Company {

    String Comapny_id;
    String Company_name;
    int Company_networth;
    int Company_photo;

    public Company(String comapny_id, String company_name, int company_networth, int company_photo) {
        Comapny_id = comapny_id;
        Company_name = company_name;
        Company_networth = company_networth;
        Company_photo = company_photo;
    }

    public String getComapny_id() {
        return Comapny_id;
    }

    public void setComapny_id(String comapny_id) {
        Comapny_id = comapny_id;
    }

    public String getCompany_name() {
        return Company_name;
    }

    public void setCompany_name(String company_name) {
        Company_name = company_name;
    }

    public int getCompany_networth() {
        return Company_networth;
    }

    public void setCompany_networth(int company_networth) {
        Company_networth = company_networth;
    }

    public int getCompany_photo() {
        return Company_photo;
    }

    public void setCompany_photo(int company_photo) {
        Company_photo = company_photo;
    }
}
