package TodayTest;

public class main {

    public static void main(String[] args) {

        int row_len=5;
        int col_len=5;
        int count=1;
        int i=0,j=0;

        int [][] res=new int[5][5];
        boolean rev=false;

        while(i<row_len && j<col_len)
        {
            if(!rev)
            {
                while(i<row_len)
                {
                    res[i][j]=count;
                    count++;
                    i++;
                }
                rev=true;
                j++;
                i--;
            }
            else {

                while(i>=0)
                {
                    res[i][j]=count;
                    i--;
                    count++;
                }
                i++;
                j++;
                rev=false;

            }

        }

        for(i=0;i<row_len;i++)
        {
            for(j=0;j<col_len;j++)
                System.out.print(res[i][j]+" ");
            System.out.println();
        }
    }
}
