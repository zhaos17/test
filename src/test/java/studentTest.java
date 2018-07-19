import com.zhaos.dao.studentInfoDAO;
import com.zhaos.entity.studentInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhaos
 * @date 2018-06-15
 */
public class studentTest {

    @Autowired
    private studentInfoDAO studentInfoDAO;

    @Test
    public void addTest() {
        studentInfo stu = new studentInfo();
        stu.setName("zhaos");
        stu.setAge("23");
        stu.setGender("男");
        studentInfoDAO.addStudent(stu);
    }

}
