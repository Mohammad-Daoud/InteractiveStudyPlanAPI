import com.university.interactivestudyplanweb.handler.ResponseHandler;
import com.university.interactivestudyplanweb.model.Course;
import com.university.interactivestudyplanweb.services.ViewStudyPlanService;
import org.junit.Test;

public class PlanTest {
    @Test
    public void postTest(){
        System.out.println(new ViewStudyPlanService().retrieveCSVPlan(2017));
    }
}
