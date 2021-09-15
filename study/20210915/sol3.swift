//
//  sol3.swift
//  algorithm
//
//  Created by 이진하 on 2021/09/15.
//

import Foundation

//MARK: - 기능개발
func solution(_ progresses:[Int], _ speeds:[Int]) -> [Int] {
    
    var progress:[Int] = progresses
    var speed:[Int] = speeds
    
    var results:[Int] = []
    
    while !progress.isEmpty {
        
        //진행속도만큼 일을 해줌
        (0..<progress.count).forEach { i in
            progress[i] = progress[i] + speed[i] <= 100 ? progress[i] + speed[i] : 100
        }
        
        var cnt = 0
        
        while ( progress.isEmpty == false ) {

            if progress.first! >= 100 {
                progress.removeFirst()
                speed.removeFirst()
                cnt += 1
            }else{
                break
            }
        }
        
        if cnt != 0 {
        
            results.append(cnt)
        }
        
    }
    
    return results
}
