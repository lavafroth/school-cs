class quiz{
    int sumfreq(String hay, char needle){
        int sum=0;
        for(int i=0;i<hay.length();i++)if(hay.charAt(i)==needle)sum+=needle;
        return sum;
    }
}