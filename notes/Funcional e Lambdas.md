# Programação Funcional

Interfaces funcionais.

1. Predicate : `implements test(T t)` : `boolean` (*tal que*)
2. Consumer : `implements accept(T t)` : `void`
3. Function<T, R> : `implements apply(T t)` : `R`

## 1. Predicate
predicate:
```java
  Predicate <Integer> pred = x ->  x >= 10;

  list.removeIf(pred);
```

jeito rudimentar:
`MyPredicate.java`:
```java
public MyPredicate implements Predicate<Integer>{

  @Override
  public boolean test(Integer x){
    return x >= 10;
  }

}
```

`Program.java`:
```java
  list.removeIf(new MyPredicate());
```

## 2. Consumer

Exemplo:
```
  list.forEach()
```

## 3. Function

É usada em Streams

```java
public class MyFunction implements Function <T, R>{

  @Override
  public R apply (T t){
    // ...
  }

} 
```

# Stream

Baseadas em ***pipelines***, isto é sequência bem definida de etapas, *linkadas* até um método terminal. Outra maneira de interpretar stream é pela expressão ***Operações Agregadas***

 - Thread-Safe por ser imutável.
 - Sem efeitos colateiras.
 - Lazy evaluation (operações sob demanda)
 - Acesso sequencial (Não há índices)
 - Uso único (Gera excessão)
 
 ## pipeline
 
 Uma operação em stream retorna uma stream anônima, que pode continuar sofrendo operações intermediárias, até receber uma operação terminal.

 ## Operções Intermediárias

- filter
- map
- flatmap
- peek
- distinct
- sorted
- skip
- limit (*sort-circuit*)