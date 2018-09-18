import com.cyc.platform.common.Application;
import com.cyc.platform.common.entity.CycInfoContentExt;
import com.cyc.platform.common.service.CycInfoContentExtService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by huzuxing on 2018/9/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CycInfoContentExtTest {
    @Resource
    private CycInfoContentExtService cycInfoContentExtService;

    @Test
    public void add() {
        CycInfoContentExt ext = new CycInfoContentExt();
        ext.setInfoId(5);
        ext.setViewCount(1);
        cycInfoContentExtService.add(ext);
    }

    @Test
    public void update() {
        CycInfoContentExt ext = new CycInfoContentExt();
        ext.setInfoId(5);
        ext.setViewCount(2);
        ext.setPraiseCount(2);
        cycInfoContentExtService.update(ext);
    }
}
