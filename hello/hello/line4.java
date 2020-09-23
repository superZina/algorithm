public class line4 {
    public static int solution(int[][] maze) {
        int[] dx = {-1,+1,0,0};
        int[] dy = {0,0,-1,+1};
    
    

        int answer = 0;
        int x = 0; 
        int y = 0;
        int direct = 1;
        if(maze[0][1] == 1) {//출발지점에서 왼쪽에 벽이 있다면
            direct = 3; //아래로 전진
        }else if(maze[0][1] == 0){//없다면
            direct = 1; //왼쪽으로 전진
        }
        while(true) {
            System.out.println("x : "+x + " y : "+y + direct);
            int left = 0;
            switch(direct) { //방향에 따른 왼쪽 방향
                case 0:
                    left = 3;
                    break;
                case 1:
                    left = 2;
                    break;
                case 2:
                    left = 0;
                    break;
                case 3:
                    left = 1;
                    break;
                default:
                        break;
            }
            //전진
            if(x == maze.length && y == maze.length ) break;
            x = x + dx[direct];
            y = y + dy[direct];
            answer++;
            int leftX = x + dx[left];
            int leftY = y + dy[left];
            //왼쪽에 벽이 있다면 전진
            int Nx = x + dx[direct];
            int Ny = y + dy[direct];
            if(x >-1&&x<maze.length&&y >=0 && y < maze.length&&maze[x][y]== 1){
                switch (direct) {
                    case 0:
                        direct = 3; 
                        break;
                    case 1:
                        direct = 2; 
                        break;
                    case 2:
                        direct = 0;
                        break;
                    case 3:
                        direct = 1;
                        break;
                    default:
                        break;
                }
                continue;
            }else if(leftX >-1&&leftX<maze.length&&leftY >=0 && leftY < maze.length&&maze[leftX][leftY] == 1 ) {
                continue;
            }else if(leftX >-1&&leftX<maze.length&&leftY >=0 && leftY < maze.length&maze[leftX][leftY] == 0){//왼쪽에 벽이 없다면 왼쪽으로 꺾고
                switch (direct) {
                    case 0:
                        direct = 3; 
                        break;
                    case 1:
                        direct = 2; 
                        break;
                    case 2:
                        direct = 0;
                        break;
                    case 3:
                        direct = 1;
                        break;
                    default:
                        break;
                }
                int nx = x + dx[direct];
                int ny = y + dy[direct];
                if(nx == -1 || ny == -1 || nx == maze.length ||ny == maze.length){
                    continue;
                }else if(nx >-1&&nx<maze.length&&ny >=0 && ny < maze.length&&maze[nx][ny]== 1) {//앞에 벽이 있다면 왼쪽으로 또 꺾고 
                    switch (direct) {
                        case 0:
                            direct = 3; 
                            break;
                        case 1:
                            direct = 2; 
                            break;
                        case 2:
                            direct = 0;
                            break;
                        case 3:
                            direct = 1;
                            break;
                        default:
                            break;
                    }
                }else{//앞에 벽이 없다면 전진한다.
                    continue;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] maze = {{0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}, {1, 0, 1, 0}};
        System.out.println(solution(maze));
    }
}

