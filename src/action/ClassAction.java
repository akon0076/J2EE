package action;

import com.opensymphony.xwork2.ModelDriven;
import dao.ClassDao;
import entity.Classes;

import java.util.Map;

public class ClassAction implements ModelDriven<Classes> {
    private Classes classes = new Classes();
    private Map<String, Object> request;
    ClassDao dao = new ClassDao();

    public String addClass() {
        dao.addClass(this.classes);
        System.out.println("��ӳɹ�");
        return "success";
    }

    public String removeClass() {
        dao.removeClass(this.classes.getId());
        System.out.println("ɾ���ɹ�");
        return "success";
    }

    public String getSingleClass() {
        this.classes = dao.getSingleClass(this.classes.getId());
        return "ToUpdate";
    }

    public String updateClass() {
        dao.updateClass(this.classes);
        System.out.println("�޸ĳɹ�");
        return "success";
    }

    public Classes getClasses() {
        return this.classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }


    @Override
    public Classes getModel() {
        return this.classes;
    }
}
