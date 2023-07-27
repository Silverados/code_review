import java.io.IOException;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path directory = Paths.get("src/main/java/test");
            directory.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);

            while (true) {
                WatchKey key;
                try {
                    key = watchService.take(); // 阻塞等待获取WatchKey
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }

                // 处理WatchKey中的事件
                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    if (kind == StandardWatchEventKinds.OVERFLOW) {
                        // 如果事件丢失或无法识别，会收到OVERFLOW事件
                        continue;
                    }

                    // 获取事件发生的文件路径
                    Path filePath = (Path) event.context();

                    // 处理文件事件
                    if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                        // 文件创建
                        System.out.println("文件创建：" + filePath);
                    } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                        // 文件修改
                        System.out.println("文件修改：" + filePath);
                    } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                        // 文件删除
                        System.out.println("文件删除：" + filePath);
                    }
                }

                // 重置WatchKey，并继续监视
                boolean valid = key.reset();
                if (!valid) {
                    // 如果WatchKey无效，可能是监视目录不可访问或已删除
                    break;
                }
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
