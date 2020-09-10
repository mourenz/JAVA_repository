package club.zqg;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Optional 作用 是防止 空指针 NPE
 * @author admin
 *
 */

public class OptionalFeatures {

    public static void main(String[] args) {
        Optional<String> hello = Optional.of("hello");
        hello.ifPresent((val) -> System.out.println(val));
        /**
         *  if (value != null)
         *             consumer.accept(value);
         */
        hello.orElse("world"); // null? world:xx
        System.out.println(hello.orElseGet(() -> "hello world"));
        Optional<Object> option = Optional.ofNullable(hello);
        System.out.println(option.get());


        // 
        Company company = new Company();
        company.setEmployes(Arrays.asList(new Employe("zqg"), new Employe("zqg1")));
        Optional<Company> companyOptional = Optional.ofNullable(company);
        List<Employe> employes = companyOptional.map((theCompany) -> theCompany.getEmployes()).orElse(Collections.emptyList());
        System.out.println(employes.size());
        // (theCompany)->theCompany.getEmployes() -->(theCompany)->{ return theCompany.getEmployes();}
        // companyOptional.map 返回 Optional



    }
}

class Employe {
    private String ename;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
    public Employe(){

    }

    public Employe(String ename) {
        this.ename = ename;
    }
}

class Company {
    private String cname;
    private List<Employe> employes;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }
}
