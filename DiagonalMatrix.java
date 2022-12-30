public class DiagonalMatrix implements Matrix {
    private  int size;
    private int n_n;
    private boolean is_transpose;
    private  double [] arr;

    public DiagonalMatrix() {
        this.is_transpose = false;
        this.size = (MAX_SIZE*2)-1;
        this.n_n = MAX_SIZE;
        this.arr = new double[this.size];
    }

    public DiagonalMatrix(int size) throws IllegalArgumentException {
        try{
            if( size > 0) {
                this.is_transpose = false;
                this.n_n = size;
                this.size = (size * 2) - 1;
                this.arr = new double[this.size];
            }else{
                throw new IllegalArgumentException();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    boolean CheckIfLegalInput(int i, int j){
        return  (i <= (n_n)) && (j <= (n_n))
                && (i >= 1) && ( j >= 1);
    }


    @Override
    public double get(int i, int j) {
        if(!CheckIfLegalInput(i,j)){
            throw new IllegalArgumentException();
        }
        if(!this.is_transpose){
            return this.arr[ ((j-i) + this.n_n)-1 ];
        }
        return this.arr[ ((i-j) + this.n_n)-1 ];
    }

    @Override
    public void set(int i, int j, double x) {
        if(!CheckIfLegalInput(i,j)){
            throw new IllegalArgumentException();
        }
        if(!this.is_transpose){
            this.arr[ ((j-i) + this.n_n) - 1] = x ;
        }
        if(this.is_transpose){
            this.arr[ ((i-j) + this.n_n) - 1] = x ;
        }

    }

    @Override
    public void transpose() {
        this.is_transpose = !this.is_transpose;
    }

    @Override
    public Matrix getTranspose() {
        DiagonalMatrix m = new DiagonalMatrix((this.size + 1)/2 );
        m.is_transpose = !this.is_transpose;
        int k = 0;
        for(double i: this.arr){
            m.arr[k] = i;
            k++;
        }
        m.n_n = this.n_n;
        m.size = this.size;
        return m;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(!is_transpose){
            for (int i = 1; i <= n_n ; i++) {
                for (int j = 1; j <= n_n; j++) {
                    if(!is_transpose){
                        sb.append(get(i, j));
                    }else{
                        sb.append(get(j, i));
                    }
                    if( (j % 3) == 0){
                        sb.append('\n');
                    }else{
                        sb.append('\t');
                    }
                }
            }
            return sb.toString();
        }
        return sb.toString();
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        int i = 0;
//        int temp_size = this.size - 1;
//        int mid = temp_size/2;
//        int j = mid;
//        while( (mid != -1) && (mid != this.size)){
//            if( (i - n_n) == 0 ){
//                if(! is_transpose) {
//                    mid--;
//                    j = mid;
//                    i = 0;
//                }else{
//                    mid++;
//                    j = mid;
//                    i = 0;
//                }
//
//            }else{
//                sb.append(this.arr[j]);
//                if(!is_transpose){
//                    j++;
//                }else{
//                    j--;
//                }
//                i++;
//                if(i%n_n == 0){
//                    sb.append('\n');
//                }else{
//                    sb.append('\t');
//                }
//            }
//        }
//        return sb.toString();
//    }


}
