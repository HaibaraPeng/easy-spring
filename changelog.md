# IOC

## 最简单的bean容器

> 分支：1-simple-bean-container

定义一个简单的bean容器BeanFactory，内部包含一个map用以保存bean，只有注册bean和获取bean两个方法

```java
public class BeanFactory {

    private final Map<String, Object> beanMap = new ConcurrentHashMap<>();

    public void registerBean(String name, Object bean) {
        beanMap.put(name, bean);
    }

    public Object getBean(String name) {
        return beanMap.get(name);
    }
}
```

测试：

```java
class BeanFactoryTest {

    BeanFactory beanFactory;

    @BeforeEach
    void setUp() {
        beanFactory = new BeanFactory();
    }

    @Test
    void getBean() {
        beanFactory.registerBean("helloService", new HelloService());
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        assertNotNull(helloService);
        assertEquals("hello", helloService.sayHello());
    }

    class HelloService {
        public String sayHello() {
            System.out.println("hello");
            return "hello";
        }
    }
}
```

## BeanDefinition和BeanDefinitionRegistry



> 代码分支：2-bean-definition

主要增加如下类：

- BeanDefinition，顾名思义，用于定义bean信息的类，包含bean的class类型、构造参数、属性值等信息，每个bean对应一个BeanDefinition的实例。简化BeanDefinition仅包含bean的class类型。
- BeanDefinitionRegistry，BeanDefinition注册表接口，定义注册BeanDefinition的方法。
- SingletonBeanRegistry及其实现类DefaultSingletonBeanRegistry，定义添加和获取单例bean的方法。

bean容器作为BeanDefinitionRegistry和SingletonBeanRegistry的实现类，具备两者的能力。向bean容器中注册BeanDefinition后，使用bean时才会实例化。

![](.\image\2\image-20241120151941801.png)

测试：

```java
class BeanFactoryTest {

    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

    @Test
    void getBean() {
        beanFactory.registerBeanDefinition("helloService", new BeanDefinition(HelloService.class));
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        assertNotNull(helloService);
        assertEquals("hello", helloService.sayHello());
    }

}

public class HelloService {

    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }
}
```