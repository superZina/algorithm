//
//  sol2.swift
//  heap
//
//  Created by 이진하 on 2021/09/20.
//

import Foundation

class Heap2 {
    var nums:[Int] = []
    
    var isEmpty:Bool {
        return nums.isEmpty
    }
    
    func add(num:Int) {
        self.nums.append(num)
        //작업시간 짧은순 대로 정렬
        self.nums = nums.sorted(by: {
            $0 < $1
        })
    }
    
    func removeFirst() -> Int {
        return self.nums.removeFirst()
    }
    
    func removeLast() -> Int {
        return nums.removeLast()
    }
}


func solution(_ operations:[String]) -> [Int] {
    
    let heap = Heap2()
    
    operations.forEach { op in
        if op.split(separator: " ").first! == "I" {
            
            let num = op.split(separator: " ").last!
            heap.add(num: Int(String(num))!)
            
        }else if op == "D 1" {
            //최댓값
            if !heap.isEmpty {
                heap.removeLast()
            }
            
        }else{
            if !heap.isEmpty {
                heap.removeFirst()
            }
            
        }
    }
    
    return heap.isEmpty == true ? [0,0] : [heap.removeLast() , heap.removeFirst()]
}
