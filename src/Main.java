import com.workintech.entity.enums.Priority;
import com.workintech.entity.enums.Status;
import com.workintech.entity.models.Task;
import com.workintech.entity.models.TaskData;
import com.workintech.entity.utils.SetUtils;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Task taskForBob1 = new Task("S15D2", "dummy desc", "bob", Priority.HIGH, Status.ASSIGNED);
        Task taskForBob2 = new Task("S15D2", "dummy desc 2", "bob", Priority.HIGH, Status.IN_PROGRESS);

        Task taskForAnn1 = new Task("S15D2", "dummy desc", "ann", Priority.HIGH, Status.ASSIGNED);
        Task taskForAnn2 = new Task("S15D2", "dummy desc 2", "ann", Priority.MEDIUM, Status.IN_PROGRESS);

        Task taskForCarol1 = new Task("S15D2", "dummy desc", "carol", Priority.LOW, Status.ASSIGNED);
        Task taskForCarol2 = new Task("S15D2", "dummy desc 2", "carol", Priority.MEDIUM, Status.IN_PROGRESS);

        Task taskUnassigned1 = new Task("S15D2", "dummy desc", null, Priority.LOW, Status.IN_QUEUE);
        Task taskUnassigned2 = new Task("S15D2", "dummy desc 2", null, Priority.LOW, Status.IN_QUEUE);

        Set<Task> annsTasks = new LinkedHashSet<>();
        Set<Task> bobsTasks = new LinkedHashSet<>();
        Set<Task> carolsTasks = new LinkedHashSet<>();
        Set<Task> unassignedTasks = new LinkedHashSet<>();
        Set<Task> allTasks = new LinkedHashSet<>();

        annsTasks.add(taskForAnn1);
        annsTasks.add(taskForAnn2);

        bobsTasks.add(taskForBob1);
        bobsTasks.add(taskForBob2);

        carolsTasks.add(taskForCarol1);
        carolsTasks.add(taskForCarol2);

        unassignedTasks.add(taskUnassigned1);
        unassignedTasks.add(taskUnassigned2);

        allTasks.add(taskForBob1);
        allTasks.add(taskForBob2);
        allTasks.add(taskForAnn1);
        allTasks.add(taskForAnn2);
        allTasks.add(taskForCarol1);
        allTasks.add(taskForCarol2);
        allTasks.add(taskUnassigned1);
        allTasks.add(taskUnassigned2);

        TaskData taskData = new TaskData(annsTasks, bobsTasks, carolsTasks, unassignedTasks);

        System.out.println("-----------1-----------");
        Set<Task> all = taskData.getTasks("all");
        SetUtils.printAllSet(all);
        System.out.println("-----------2-----------");
        SetUtils.printAllSet((taskData.getAnnsTasks()));
        SetUtils.printAllSet((taskData.getBobsTasks()));
        SetUtils.printAllSet((taskData.getCarolsTasks()));
        System.out.println("-----------3-----------");
        SetUtils.printAllSet(unassignedTasks);
        System.out.println("-----------4-----------");
        Set<Task> intersectionBobAnn = taskData.getIntersection(bobsTasks, annsTasks);
        Set<Task> intersectionAnnCarol = taskData.getIntersection(annsTasks, carolsTasks);
        Set<Task> intersectionCarolBob = taskData.getIntersection(carolsTasks, bobsTasks);
        SetUtils.printAllSet(intersectionBobAnn);
        SetUtils.printAllSet(intersectionAnnCarol);
        SetUtils.printAllSet(intersectionCarolBob);
    }
}