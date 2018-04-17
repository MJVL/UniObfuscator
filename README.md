# UniObfuscator
Simple Java Obfuscator that hides code in comment tags and Unicode garbage by making use of Java's Unicode Escapes.

## Example
Source Code
```Java
System.out.println("Hello World!");
```
Obfuscated Code
```
/*\u002a\u002f\u0053\u0079\u0073\u0074\u0065\u006d\u002e\u006f\u0075\u0074\u002e\u0070\u0072\u0069\u006e\u0074\u006c\u006e\u0028\u0022\u0048\u0065\u006c\u006c\u006f\u0020\u0057\u006f\u0072\u006c\u0064\u0021\u0022\u0029\u003b\u002f\u002a*/
```
