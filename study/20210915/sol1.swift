//
//  sol1.swift
//  algorithm
//
//  Created by 이진하 on 2021/09/15.
//

import Foundation
//MARK: - 다리를 지나는 트럭

func solution(_ bridge_length:Int, _ weight:Int, _ truck_weights:[Int]) -> Int {
    
    var trucks:[Int] = truck_weights
    
    var time:Int = 0
    var road:[Int] = []
    var restTime:[Int] = []
    var roadWeight:Int = 0
    
    while !trucks.isEmpty {
        time += 1
        restTime = restTime.map({ $0 - 1 })
        
        //트럭이 다 빠져나기 까지 길이만큼의 시간이 걸림
        
        if !road.isEmpty {
            if restTime.first! == 0 {
                
                roadWeight -= road.first!
                road.removeFirst()
                restTime.removeFirst()
                
            }
        }
        
        //무게를 견딜 수 있다면
        if trucks.first! + roadWeight <= weight && road.count + 1 <= bridge_length {
            roadWeight += trucks.first!
            road.append(trucks.first!)
            restTime.append(bridge_length)
            trucks.removeFirst()
        }
        
        print("time : \(time) , road : \(road) , restTimes : \(restTime) , roadWeight : \(roadWeight)")
    }
    
    while !restTime.isEmpty {
        time += 1
        restTime = restTime.map({ $0 - 1 })
        //트럭이 다 빠져나기 까지 길이만큼의 시간이 걸림
        
        if !road.isEmpty {
            if restTime.first! == 0 {
                
                roadWeight -= road.first!
                road.removeFirst()
                restTime.removeFirst()
                
            }
        }
        print("time : \(time) , road : \(road) , restTimes : \(restTime) , roadWeight : \(roadWeight)")
    }
    
    return time
}


//print(solution(2, 10, [7,4,5,6]))
