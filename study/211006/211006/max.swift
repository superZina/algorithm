////
////  max.swift
////  211006
////
////  Created by 이진하 on 2021/10/06.
////
//
//import Foundation
//
//var result:Int = -1
//func back(cnt:Int ,n:Int, arr:[Int] , list:inout [Int]){
//    if cnt == n {
//        let num = Int(list.map({String($0)}).joined())!
//        result = max(result, num)
//
//    }else{
//        for i in 0..<n {
//            if !list.contains(arr[i]) {
//                list.append(arr[i])
//                back(cnt: cnt+1, n: n, arr: arr, list: &list)
//                list.removeLast()
//            }
//        }
//    }
//}
//
//func solution(_ numbers:[Int]) -> String {
//    var list:[Int] = numbers.sorted { num1 , num2 in
//
//        let numArr1 = Array(String(num1))
//        let numArr2 = Array(String(num1))
//
//        if String(numArr1.first!) == String(numArr2.first!){
//
//            if String(numArr1.first!) == String(numArr2.first!) {
//
//            }
//        }
//
//        return firstNum1 < firstNum2
//
//    }
////    back(cnt: 0, n: numbers.count, arr: numbers, list: &list)
//
//    return String(result)
//}
