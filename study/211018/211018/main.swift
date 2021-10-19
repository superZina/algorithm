//
//  main.swift
//  211018
//
//  Created by 이진하 on 2021/10/18.
//

import Foundation

typealias checkDir = [Bool]
// 0 : 수직 , 1 : 수평 , 2 : 기울기 1 , 3: 기울기 -1
let dx:[Int] = [1,-1, 0,0 , -1,+1, -1,+1]
let dy:[Int] = [0,0, -1,1 , +1,-1, -1,+1]

var arr:[[Int]] = []
var checkArr:[[checkDir]] = []

(0..<19).forEach { i in
    let checkarr:[checkDir] = Array<checkDir>(repeating: [false,false,false,false], count: 19)
    checkArr.append(checkarr)
    arr.append( readLine()!.split(separator: " ").map({Int(String($0))!}) )
}

let checkLimit:( (_ x:Int ,_ y:Int) -> Bool ) = {x,y in
    return x >= 0 && y >= 0 && x < 19 && y < 19
}

//검정 : 1
//흰색 : 2
func SequeningPieces(color:Int, x: Int , y:Int ,dir:Int ,cnt:Int) -> Int {
    
        let nx = x + dx[dir]
        let ny = y + dy[dir]
        //범위를 벗어나지 않고, 현재 같은 타입의 바둑알이어야 재귀로 넘어감.
        if checkLimit(nx,ny) != false && arr[nx][ny] == color {
            let idx = dir/2
            checkArr[nx][ny][idx] = true
            return SequeningPieces(color: color, x: nx, y: ny, dir: dir, cnt: cnt + 1)
        }
    
    return cnt
}

var blackWin = false
var whiteWin = false

for i in 0..<19 {
    
    if blackWin || whiteWin { break }
    
    for j in 0..<19 {
        
        if blackWin || whiteWin { break }
        
        for k in 0..<4 {
            //체크하지 않은 방향이라면
            if !checkArr[i][j][k] {
                
                let color = arr[i][j]
                let cnt = SequeningPieces(color: color, x: i, y: j, dir: k*2, cnt: 0) + SequeningPieces(color: color, x: i, y: j, dir: k*2 + 1 , cnt:0) - 1
                
                if cnt == 5 {
                    if color == 1 {
                        blackWin = true
                        print(1)
                        
                    }
                    else {
                        whiteWin = true
                        print(2)
                    }
                    print("\(i) \(j)")
                    break
                }
             
            }
        }
    }
}


