public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        DataBase x = new DataBase(32);

        for (int i = 0; i < 64; i++) {
            CompanyAddress a = new CompanyAddress();
            a.country = "хуй";
            a.city = "залупа";
            a.street = "калатушкина";
            a.house = i;
            x.add(a);
        }
        System.out.println(x);
        x.resize(16);
        System.out.println(x);
    }
}