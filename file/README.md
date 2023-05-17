# Manorrock Hummingbird - File implementation

This implementation puts an abstraction over the regular File API so it conforms
to the Hummingbird API. The API assumes you first create a VirtualFileSystem
instance which you then use to get a VirtualFile from.

```java
  VirtualFileSystem fileSystem = new FileVirtualFileSystem(".");
  VirtualFile file = fileSystem.getFile("pom.xml");
```
