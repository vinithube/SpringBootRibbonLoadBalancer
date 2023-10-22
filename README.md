# SpringBootRibbonLoadBalancer
Ribbon is a `client-side` load balancer that gives you a lot of control over the behavior of `HTTP` and `TCP `clients. Feign already uses `Ribbon`,
so, if you use `@FeignClient`, this section also applies.
A central concept in Ribbon is that of the named client. Each load balancer is part of an ensemble of components that work together to contact a remote server on demand, 
and the ensemble has a name that you give it as an application developer (for example, by using the `@FeignClient` annotation). 
