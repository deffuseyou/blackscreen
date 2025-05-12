# blackscreen (java)


## ⚙️ Build | Сборка 

```bash
javac -d build src/app.java
cd build
jar cfe blackscreen.jar app *.class
```

### macOS (.app)

```bash
jpackage --type app-image --name blackscreen --input build --main-jar blackscreen.jar --main-class app --dest dist
```

### Windows (.exe)

```bash
jpackage --type exe --name blackscreen --input build --main-jar blackscreen.jar --main-class app --dest dist --win-console
```

## 📄 License | Лицензия

MIT License  
Free to use and modify.