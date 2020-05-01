package club.chenlinghong.demo.mock.mockito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Mockito 提供的 Runner
 *
 * 如果不使用 MockitoJUnitRunner 而采用 Spring Runner，
 * 则需要添加 MockitoAnnotations.initMocks(this)；开启 Mockito 注解
 */
// Mockito 提供的 Runner
@RunWith(MockitoJUnitRunner.class)
public class MockitoServiceTest {

    // 注入 mock 对象，允许内部依赖 mock
    @InjectMocks
    MockitoService mockitoService;

    // mock 对象
    @Mock
    MockitoDao mockitoDao;

    @Before
    public void mockData() {
        // MockitoAnnotations.initMocks(this);

        // mock 行为
        Mockito.when(mockitoDao.getData()).thenReturn("mockito");
    }

    @Test
    public void getData() {
        String data = mockitoService.getData();
        Assert.assertEquals("service:mockito", data);
    }
}