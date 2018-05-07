# prefix-tree-x
Hash-table based prefix tree written in Java 10

## Example

````Java
var items = Arrays.asList(new StrItem("A", 1000), new StrItem("AB", 2000));
var tree = new CharPrefixTree(items);
assertEquals(tree.seek(new CharNode(0,0,'A')), new IntTarget(0, true, 1000));
````
