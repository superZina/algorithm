//
//  sol1.swift
//  heap
//
//  Created by 이진하 on 2021/09/20.
//

import Foundation

class Heap {
    var tasks:[[Int]] = []
    
    var isEmpty:Bool {
        return tasks.isEmpty
    }
    
    func add(task:[Int]) {
        self.tasks.append(task)
        //작업시간 짧은순 대로 정렬
        self.tasks = tasks.sorted(by: {
            $0.last! < $1.last!
        })
    }
    
    func removeFirst() -> [Int] {
        return self.tasks.removeFirst()
    }
}

func solution(_ jobs:[[Int]]) -> Int {
    let heap = Heap()
    
    var list = jobs.sorted(by: {
        if $0.first! == $1.first! {
            return $0.last! < $1.last!
        }
        return $0.first! < $1.first!
    })
    
    var task:[Int] = []
    var time = 0
    var times:[Int] = []
    
    while true {
        print(task)
        print(heap.tasks)
        print("time: \(time)")
        print("times: \(times)")
        print("list:\(list)")
        //현재 작업중이 아니면 작업을 빼줌
        if heap.isEmpty {
            
            if list.isEmpty {
//                time += task.last ?? 0
//                times.append(time - (task.first ?? 0 ))
                break
            }
            
            task = list.removeFirst()
            time = task.first!
            heap.add(task: task)
            
        }
        //현재 task일이 끝나기 전에 요청이 들어온다면, 해당 작업들을 대기큐에 넣어주고 스케줄링 진행
        task = heap.removeFirst()
        
        let requests = list.filter({$0.first! < time + task.last!})
        list = list.filter({$0.first! >= time + task.last!})
        
        requests.forEach { req in
            heap.add(task: req)
        }
        
        time += task.last!
        times.append(time - task.first!)
        
//        task = heap.isEmpty == true ? [] : heap.removeFirst()
    }
    
    
//    print(times)
//    print(times.reduce(0, +))
    return times.reduce(0, +) / times.count
}
