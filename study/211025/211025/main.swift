//
//  main.swift
//  211025
//
//  Created by 이진하 on 2021/10/25.
//

import Foundation

let inputs = readLine()!.split(separator: " ").map({Int(String($0))!})
let N = inputs.first!
let M = inputs.last!
var res = 0
var arr:[[Int]] = []
var empty:[(Int,Int)] = []
var viruses:[(Int,Int)] = []
let dx:[Int] = [0,0,1,-1]
let dy:[Int] = [1,-1,0,0]

(0..<N).forEach { _ in
    arr.append(readLine()!.split(separator: " ").map({
        Int(String($0))!
    }))
}

(0..<N).forEach { i in
    (0..<M).forEach { j in
        if arr[i][j] == 0 {empty.append((i,j))}
        if arr[i][j] == 2 {viruses.append((i,j))}
    }
}

//범위 체크
func check(x:Int , y:Int) -> Bool {
    return x >= 0 && x < N && y >= 0 && y < M
}

func safeArea(arr:[[Int]]) -> Int {
    var cnt = 0
    (0..<arr.count).forEach { i in
        (0..<arr[0].count).forEach { j in
            if arr[i][j] == 0 {cnt += 1}
        }
    }
    return cnt
}

func backTracking( idx:Int, list: inout [(Int,Int)]) {
    if list.count == 3 {
        //바이러스 증식시켜 안전영역 구하기
        var tmp = arr
        list.forEach { (i,j) in
            tmp[i][j] = 1
        }
        
        var tmpViruses = viruses
        
        while !tmpViruses.isEmpty {
            let virus = tmpViruses.removeFirst()
            for i in 0..<4 {
                let nx = virus.0 + dx[i]
                let ny = virus.1 + dy[i]
                if check(x: nx, y: ny) && tmp[nx][ny] == 0 {
                    tmp[nx][ny] = 2
                    tmpViruses.append((nx,ny))
                }
            }
        }
        
        res = max(safeArea(arr: tmp), res)
        
    }else {
        for i in idx..<empty.count {
            
            list.append(empty[i])
            backTracking(idx: i+1, list: &list)
            list.removeLast()
            
        }
    }
}

var list:[(Int,Int)] = []

backTracking(idx: 0,  list: &list)

print(res)
