# 工厂模式

## 1. 定义

Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

定义一个用于创建对象的接口，让子类决定实例化拿一个类。工厂方法使一个类的实例化延迟到其子类

**简单工厂模式**

一个模块仅需要一个工厂类，没有必要把它产生出来，使用静态的方法

**多个工厂类**

每个人种（具体的产品类）都对应一个创建者，每个创建者独立负责创建对应的产品对象，非常符合单一职责原则

**代替单例模式**

单例模式的核心要求是在内存中只有一个对象，通过工厂方法模式也可以只在内存中生产一个对象


