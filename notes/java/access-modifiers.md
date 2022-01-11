### Modifiers

We already saw two different **modifiers** on the `main` method above - one is an **access modifier** and the other is a **non-access modifier**. 

#### Access Modifiers

Access modifiers are keywords which define the ability of other code to access the given entity. Modifiers can be placed on classes, interfaces, enums, and class members. The access modifiers are listed below:

| Modifier | Access Level |
| --- | --- |
| `public` | Available anywhere |
| `protected` | Within the same package, and this class' sub-classes |
| `default` | Within the same package |
| `private` | Only within the same class |
<br>

The `default` access level requires additional clarification - this access level is "default" because **there is no keyword** to be used. This access level is also known as "package private".

Using `private` modifiers on instance variables - along with public getter and setter methods - helps with **encapsulation**, which is one of the pillars of object-oriented programming.
