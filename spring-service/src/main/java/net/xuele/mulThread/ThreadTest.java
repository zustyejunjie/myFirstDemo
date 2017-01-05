//package net.xuele.mulThread;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.concurrent.*;
//
///**
// * Created by yejunjie on 2017/1/2.
// */
//public class ThreadTest {
//
//
//    public static void main(String[] args) {
//
//        //普通的runnable
//        Runnable task = () -> {
//            String threadName = Thread.currentThread().getName();
//            System.out.println("Hello " + threadName);
//        };
////        task.run();
//
//
//        //executors
//        ExecutorService executor = Executors.newFixedThreadPool(1);
//        executor.submit(() -> {
//            for (int i = 0; i < 10; i++) {
//                String threadName = Thread.currentThread().getName();
////                System.out.println("Hello " + threadName);
//            }
//        });
//
//        //callables
//        Callable<Integer> task1 = () -> {
//            try {
//                TimeUnit.SECONDS.sleep(5);
//                return 123;
//            } catch (InterruptedException e) {
//                throw new IllegalStateException("task interrupted", e);
//            }
//        };
//
//        Future<Integer> future = executor.submit(task1);
//
////        System.out.println("future done? " + future.isDone());
//
//        Integer result = null;
//        try {
//            result = future.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
////        System.out.println("future done? " + future.isDone());
////        System.out.println("result: " + result);
//
//
//        List<Callable<String>> callables = Arrays.asList(
//                () -> "task1",
//                () -> "task2",
//                () -> "task3");
//
//        try {
//            executor.invokeAll(callables)
//                    .stream()
//                    .map(future1 -> {
//                        try {
//                            return future1.get();
//                        } catch (Exception e) {
//                            throw new IllegalStateException(e);
//                        }
//                    })
//                    .forEach(System.out::println);
//        }catch (Exception e){
//
//        }
//
//
//
//        //需要显示的关闭executor
//        try {
//            System.out.println("attempt to shutdown executor");
//            executor.shutdown();
//            executor.awaitTermination(5, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            System.err.println("tasks interrupted");
//        } finally {
//            if (!executor.isTerminated()) {
//                System.err.println("cancel non-finished tasks");
//            }
//            executor.shutdownNow();
//            System.out.println("shutdown finished");
//        }
//    }
//}
