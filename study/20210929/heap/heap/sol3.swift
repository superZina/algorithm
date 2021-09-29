//
//  sol3.swift
//  heap
//
//  Created by 이진하 on 2021/09/20.
//

import Foundation

//사칙연산으로 x를 표현할 수 있는 N 최소 개수
var Num:Int = 0
var dp:[Int] = Array<Int>(repeating: Int.max, count: 32000)
//N = 5
/// 1
// N = 1 이면 dp[1] = 1
// dp[1] = 2 ( N / N )
///2
//dp[2] = dp[1] + dp[1] = 4
//      = 3 ( 5 + 5 ) / 5
///3
//dp[3] = dp[1] + dp[2] = 5
//      = dp[1] + dp[1] + dp[1] = 6
//      = 4 ( 5 + 5 + 5 ) / 5
///4
//dp[4] = dp[1] + dp[3] = 6
//      = dp[2] + dp[2] = 6
//      = 5 ( 5 + 5 + 5 + 5 ) / 5
/// 5
//dp[5] = 1
/// 6
//dp[6] = dp[5] + dp[1] = 3
//      = dp[2] + dp[4] = 8
//      = dp[3] + dp[3] = 8
//      = 7 ( 5 + 5 + 5 + 5 + 5 + 5 ) / 5
///11
//dp[11] = 3 ( NN / N )
///13
//dp[13] = dp[x] + dp[13 - x]
//       = 14
//       = 5 ( 55 + 5 + 5 ) / 5
//

func numberOfOne(num:Int) -> Int {
    var n = num
    var cnt = 0
    var max = 11111
    var numOfOne = 5
    while n > 0 {        
        if n >= max {
            cnt += numOfOne*(n/max)
            n %= max
            
        }else{
            max /= 10
            numOfOne -= 1
        }
    }
    return cnt
}


func numberOfN(num:Int) -> Int {
    var n = num
    var cnt = 0
    
    while n > 0 {
        n /= Num
        if n != 0 {
            cnt += 1
        }
    }
    
    return cnt
}

func dp(num:Int) -> Int {
    if num <= 0 { return Int.max }
    if num == 1 { return Num == 1 ? 1 : 2 }
    if num == Num { return 1 }
    if 11 * Num == num { return 2 }
    if 111 * Num == num { return 3 }
    if 1111 * Num == num { return 4 }
    if 11111 * Num == num { return 5 }
    if dp[num] != Int.max { return dp[num] }
    else {
        if dp[num] == 0 { print("0 num: \(num) , dp[num]: \(dp[num])")}
        
        (1..<num).forEach { i in
            dp[num] = min(dp[num], dp(num: i) + dp(num: num - i))            
        }
        dp[num] = min(dp[num],Num == 1 ? numberOfOne(num: num) :  numberOfOne(num: num)+1)
        return dp[num]
    }
}

func solution(_ N:Int, _ number:Int) -> Int {
    Num = N
    let ans = dp(num: number)
    return  ans > 8 ? -1 : ans
}
