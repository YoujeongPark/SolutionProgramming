package main.java;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WatchClass {

    public void watchFile() throws IOException, InterruptedException {

        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get(".\\INPUT\\"); // 주소지정
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,//파일생성
                                    StandardWatchEventKinds.ENTRY_DELETE,//파일삭제
                                    StandardWatchEventKinds.ENTRY_MODIFY);//파일변경

        Boolean watchYN = false;

        while(true) {

            //WatchKey watchKey = watchService.poll(10, TimeUnit.SECONDS); // 시간을 정해야할때
            WatchKey watchKey = watchService.take(); // 등록한 이벤트 발생 시 WatchKey로 반환 - 무제한

            List<WatchEvent<?>> list = watchKey.pollEvents(); // 이벤트 추출, ?는 와일드 카드 타입


            if(watchKey == null){
                break;
            }

            for(WatchEvent e: list) {
                WatchEvent.Kind eventKind = e.kind();
                Path eventFileName = (Path) e.context();

                if(eventKind == StandardWatchEventKinds.ENTRY_CREATE){
                    System.out.println("ENTRY_CREATE");
                    watchYN = true;
                    break;
                }
                System.out.println(eventKind); // CREATE or DELETE or MODIDTY
                System.out.println(eventFileName); // 파일 이름
            }

            boolean success = watchKey.reset(); // event 완료시 리셋 필요 -> 리셋하지않으면 일회성
            System.out.println(success);

            if(watchYN) break;

        }

    }


}
