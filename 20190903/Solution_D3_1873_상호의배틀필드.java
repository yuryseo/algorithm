import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1873_상호의배틀필드 {
	static int h, w,num;
	static char[][] arr;
	static int tankx, tanky, direction;
	static char current;
	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };// 상하좌우

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		String str;

		for (int t = 1; t <= testcase; t++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			arr = new char[h][w];
			tankx=0;
			tanky=0;
			for (int i = 0; i < h; i++) {
				str = br.readLine();
				for (int j = 0; j < w; j++) {
					arr[i][j] = str.charAt(j);
					if(arr[i][j]=='<' ||arr[i][j]=='>' ||arr[i][j]=='^' || arr[i][j]=='v') {
						tankx = i; tanky = j;
					}
					
				}
			}
			//SURSSSSUSLSRSSSURRDSRDS
			num = Integer.parseInt(br.readLine());
			str = br.readLine();
			direction  = finddirection();
			int nx,ny;
			for (int i = 0; i < str.length(); i++) {
				current = str.charAt(i);
				if (current == 'S') { // 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
					//nx,ny
					nx = tankx+dx[direction];
					ny = tanky+dy[direction];
					while(ISin(nx, ny)) {
						if(arr[nx][ny] =='*') {
							arr[nx][ny] = '.';
							 break;
						}else if(arr[nx][ny] =='#') {
							break;
						}
						nx+=dx[direction];
						ny+=dy[direction];
						
					}
					
					
				} else {
					if (current == 'U') {
						direction = 0;
						arr[tankx][tanky] = '^';
					} else if (current == 'D') {
						direction = 1;
						arr[tankx][tanky] = 'v';
					}else if (current == 'L') {
						direction = 2;
						arr[tankx][tanky] = '<';
					}else if (current == 'R') {
						direction = 3;
						arr[tankx][tanky] = '>';
					}
					 nx = tankx + dx[direction];
					 ny = tanky + dy[direction];
					if (ISin(nx, ny) && arr[nx][ny] == '.') {
						arr[nx][ny] = arr[tankx][tanky];
						arr[tankx][tanky]='.';
						tankx = nx;
						tanky = ny;
					}

				}

			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}

		}

	}

	private static boolean ISin(int nx, int ny) {
		
		return (nx >= 0 && nx < h && ny >= 0 && ny < w);
	}

	private static int finddirection() {
		char temp = arr[tankx][tanky];
		if(temp=='^') {
			return  0;
		}else if(temp=='v') {
			return 1;
		}else if(temp=='<') {
			return 2;
		}else if(temp=='>') {
			return 3;
		}
		return 5;
	}
}
