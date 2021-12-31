public class dasy {

    public static void insertionSorting(int[] data,int n){
        int tmp;
        for(int j=1;j<n;j++) { // j는 새로 비교할 값의 인덱스

            for (int i = 0; i < j; i++) { // data[j]를 data[j-1] 부터 data[0]까지 비교하는 과정
                if (data[j-i-1] > data[j-i]) { // data[j-1]보다 data[j-i-1]이 더 큰 경우
                    tmp = data[j-i-1];
                    data[j-i-1] = data[j-i]; // 서로 바꿔준다.
                    data[j-i] = tmp;
                }

            }
            for(int k=0;k<n;k++){ // 출력
                System.out.print(data[k]+" ");
            }
            System.out.println();
        }
    }

    public static void selectionSorting(int[] data, int n){
        int i,j, big, temp;
        for(i=n-1;i>0;i--){ // 배열의 맨 끝에 가장 큰 값을 매번 저장하고 고정하기 위해
            big=0;
            for(j=1;j<=i;j++) // 배열 값을 조회하면서 가장 큰 값의 인덱스를 big에 저장한다.
                if(data[big]<data[j])
                    big=j;

            temp=data[i];
            data[i]=data[big];
            data[big]=temp; // 가장 큰 값과 맨 뒤의 값을 서로 바꿔준다.

            for(int k=0;k<n;k++){
                System.out.print(data[k]+" ");
            }
            System.out.println();
        }
    }
    public static void mergeSorting(int data[], int left , int right){
        if(left < right) { // 크로스 되지 않는 한
            int mid = (left+right)/2; // 가운데 값
            mergeSorting(data,left,mid);  // mid를 기준으로 반쪽으로 나눠진 배열 중 왼쪽 배열
            mergeSorting(data,mid+1,right); // mid를 기준으로 반쪽으로 나눠진 배열 중 오른쪽 배열
            merge(data,left,mid,right); // 합치기
        }
    }

    private static void merge(int[] data,int left, int mid,int right) {
        int temp[] = new int[(right-left)+1]; // 임시로 저장할 배열
        int n1 = left; // 왼쪽 배열의 첫 번째 인덱스 값
        int n2= mid+1; // 오른쪽 배열의 첫 번째 인덱스 값
        int index = 0; // 임시 배열에 저장된 원소 개수 (인덱스 값)

        while(n1 <= mid && n2 <= right) { // 인덱스 n1은 왼쪽 배열의 마지막인 mid, 인덱스 n2는 오른쪽 배열의 마지막은 right를 넘을 수 없다.
            if (data[n1] < data[n2]) // 배열의 값을 비교
                temp[index++] = data[n1++]; // 임시 배열에 더 작은 값을 저장하고, 인덱스 값을 늘려준다.
            else
                temp[index++] = data[n2++];
        }

        // n1이나 n2가 각각 나눠진 배열의 맨 끝에 도달하면 while 문을 벗어남 - 아직 임시 배열에 저장되지 않은 원소가 남아있는 부분을 저장해야함.
        if(n1<= mid)  // 왼쪽 배열이 남은 경우
            while(n1 <= mid) // n1이 mid(왼쪽 배열의 끝) 에 도달할 때까지
                temp[index++] = data[n1++]; //
        else // 오른쪽 배열이 남은 경우
            while(n2 <= right) // n2이 right(오른쪽 배열의 끝) 에 도달할 때까지
                temp[index++] = data[n2++];

    }

    public static void quickSorting(int[] data, int first, int n){
        int pivotIndex;
        int n1; // 왼쪽 배열의 원소 개수
        int n2; // 오른쪽 배열의 원소 개수

        if(n>1){
            pivotIndex=partition(data,first,n);
            n1=pivotIndex-first; // 왼쪽 배열 원소 개수
            n2=n-n1-1; // 오른쪽 배열 원소 개수
            quickSorting(data,first,n1); // 피벗 값을 기준으로 왼쪽 배열을 재귀
            quickSorting(data,pivotIndex+1,n2); // 피벗을 기준으로 오른쪽 배열을 재귀
        }
    }

    private static int partition(int[] data, int first, int n) {
        int pivot = data[first]; // 배열의 첫번째 값을 pivot으로 한다.
        int tooBigIndex = first + 1;
        int tooSmallIndex = first + n - 1;
        int changeLeft=-1; // data[tooBigIndex] 가 pivot보다 큰 것을 발견했을 때의 index 저장.
        int changeRight=-1; // data[tooSmallIndex] 가 pivot보다 작은 것을 발견했을 때의 index 저장.
        while (tooBigIndex <= tooSmallIndex) { // 서로 크로스 되기 전까지
            int temp;
            boolean changeLeftExist=false;
            boolean changeRightExist=false;

            if(data[tooBigIndex]>pivot) { // data[tooBigIndex]가 pivot 보다 크면
                changeLeft = tooBigIndex;
                changeLeftExist = true;
            }
            else tooBigIndex++; // 작으면 통과하기

            if(data[tooSmallIndex]<pivot) { // data[tooSmallIndex]가 pivot보다 작으면
                changeRight = tooSmallIndex;
                changeRightExist = true;
            }
            else tooSmallIndex--; // 크면 통과

            if(changeLeftExist && changeRightExist) { // 서로 바꿀 숫자가 모두 존재하면 서로 바꿔줌
                temp=data[changeLeft];
                data[changeLeft]=data[changeRight];
                data[changeRight]=temp;
                tooBigIndex++; tooSmallIndex--;
            }
        }

        int tmp;
        tmp=data[first]; // data[first]와 data[tooSmallIndex] 값을 바꿔준다.
        data[first]=data[tooSmallIndex];
        data[tooSmallIndex]=tmp;


        for(int i=0;i<data.length;i++)
            System.out.print(data[i]+" ");
        System.out.println();
        return tooSmallIndex; // 리턴 값(pivotIndex)는 tooSmallIndex 이다.
    }
    public static void main(String[] args) {
        int array[] = { 12, 30, 21, 55, 25, 72, 45, 50 };
        mergeSorting(array,0,7);

        for(int n=1000;n<=20000;n+=1000) {
            double[] darray = new double[n];
            int[] iarray = new int[n];
            for (int i = 0; i < n; i++) {
                darray[i] = (double) Math.random() * 2 - 1;
                iarray[i] = (int) darray[i] * 1000;
            }
            System.out.println();
            long startTime = System.currentTimeMillis();
            mergeSorting(iarray, 0, n - 1);
            long estimatedTime = System.currentTimeMillis() - startTime;
            System.out.println(n+" 에서 " +estimatedTime);
        }


        /*
        double* darray = (double*)malloc(sizeof(double) * n);
	int* iarray1 = (int*)malloc(sizeof(int) * n);

	for (int i = 0; i < n; i++) {
		darray[i] = ((double)rand() / 32767) * 2 - 1;
		iarray1[i] = darray[i] * 1000;
	}

	start = clock();
	mergeSort(iarray1, 0, n-1, false);
	end = clock();
	printf("병합정렬 : %d 일 때 밀리초 -- %.3lf ms\n\n", n, 1000.0 * (end - start) / CLOCKS_PER_SEC);
         */
    }
}

