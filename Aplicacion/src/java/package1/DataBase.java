package package1;

public class DataBase {

    //private static String[] datos;
    public static void main(String[] args) {

        RequestPackage ClientGet = new RequestPackage();
        ClientGet.setUri("http://localhost:8080/meditecserver/webapi/clientlist");
        ClientGet.setMethod("GET");
        String responseCL = HttpManager.getData(ClientGet);

        RequestPackage AppointmentGet = new RequestPackage();
        AppointmentGet.setUri("http://localhost:8080/meditecserver/webapi/appointmentlist");
        AppointmentGet.setMethod("GET");
        String responseAL = HttpManager.getData(AppointmentGet);

        // infoClient(responseDL);
        // String Diary = "<html><head><title>Diary</title><meta
        // charset='utf-8'><link rel='stylesheet' type='text/css'
        // href='sheet.css'><script>function mostrar(id) {obj =
        // document.getElementById(id);obj.style.visibility =
        // (obj.style.visibility == 'hidden') ? 'visible' :
        // 'hidden';}</script></head><body>"
        // + agenda(responseDL) + "</body></html>";
        //agenda(responseAL);
        //String Clients = "<html><head><title>Clients</title><meta charset='utf-8'><link rel='stylesheet' type='text/css' href='sheet.css'><script>function mostrar(id) {obj = document.getElementById(id);obj.style.visibility = (obj.style.visibility == 'hidden') ? 'visible' : 'hidden';}</script></head><body>"
        //+ clientes(responseCL) + "</body></html>";
        // infoClient(responseAL);
        // String Appoinments = "<html><head><title>Appoinments</title><meta
        // charset='utf-8'><link rel='stylesheet' type='text/css'
        // href='sheet.css'></head><body>"
        // + citas(responseAL) + "</body></html>";
    }

    public static String[] DoctorList(String id, String name) {
        RequestPackage DoctorGet = new RequestPackage();
        DoctorGet.setUri("http://localhost:8080/meditecserver/webapi/doctorlist?id=" + id);
        System.out.println(DoctorGet.getUri());
        DoctorGet.setMethod("GET");
        String doctorlist = HttpManager.getData(DoctorGet);
        if (doctorlist.substring(1, doctorlist.length() - 2).equals("")) {
            String[] atributes = {"id", "points", "profileName"};
            String[] values = {"" + id, "0", "" + name + ""};
            String url = "http://localhost:8080/meditecserver/webapi/doctorlist";
            Post(atributes, values, url);
            DoctorGet.setMethod("GET");
            doctorlist = HttpManager.getData(DoctorGet);
        }
        doctorlist = doctorlist.substring(2, doctorlist.length() - 4);
        String datos[] = doctorlist.split(",");
        for (int i = 0; i < datos.length; i++) {
            int length = datos[i].split(":")[1].length();
            if (i != 1) {
                datos[i] = datos[i].split(":")[1].substring(1, length);
            } else {
                datos[i] = datos[i].split(":")[1];
            }
        }
        return datos;
    }

    public static String[][] DiaryList(String id) {
        RequestPackage DiaryGet = new RequestPackage();
        DiaryGet.setUri("http://localhost:8080/meditecserver/webapi/doctorlist?id=" + id);
        System.out.println(DiaryGet.getUri());
        DiaryGet.setMethod("GET");
        String diarylist = HttpManager.getData(DiaryGet);
        if (diarylist.substring(1, diarylist.length() - 2).equals("")) {

        }
        diarylist = diarylist.substring(2, diarylist.length() - 4);
        String datos[] = diarylist.split("}");
        String datos1[][] = new String[datos.length][3];
        for (int i = 0; i < datos.length; i++) {
            int length = datos[i].split(",")[1].length();
            if (i != 1) {
                datos[i] = datos[i].split(",")[1].substring(1, length);
            } else {
                datos[i] = datos[i].split(",")[1];
            }
        }
        return datos1;
    }
    public static String[] AppointmentsList(String id) {
        RequestPackage AppointmentGet = new RequestPackage();
        AppointmentGet.setUri("http://localhost:8080/meditecserver/webapi/appointmentlist?patientName=" + id);
        AppointmentGet.setMethod("GET");
        String appointmentslist = HttpManager.getData(AppointmentGet);
        if (appointmentslist.substring(1, appointmentslist.length() - 2).equals("")) {
            String[] datos = new String [1];
            datos[0]="";
            return datos;
        }else{
            appointmentslist = appointmentslist.substring(2, appointmentslist.length()-2);
            System.out.println(appointmentslist);
            String datos[] = appointmentslist.split("}");
            for (int i = 0; i < datos.length; i++) {
                if(i!=0){
                    datos[i]=datos[i].substring(2,datos[i].length());
                }
            }
            return datos;
        }
    }
    public static String[] CasesList(String id) {
        RequestPackage AppointmentGet = new RequestPackage();
        AppointmentGet.setUri("http://localhost:8080/meditecserver/webapi/clinicalcaselist?patientName=" + id);
        AppointmentGet.setMethod("GET");
        String appointmentslist = HttpManager.getData(AppointmentGet);
        if (appointmentslist.substring(1, appointmentslist.length() - 2).equals("")) {
            String[] datos = new String [1];
            datos[0]="";
            return datos;
        }else{
            appointmentslist = appointmentslist.substring(2, appointmentslist.length()-2);
            System.out.println(appointmentslist);
            String datos[] = appointmentslist.split("}");
            for (int i = 0; i < datos.length; i++) {
                datos[i]=datos[i].substring(0,datos[i].length());
            }
            String[] datos1 = new String [3];
            datos1[0]=datos[0].split(",")[0].split(":")[1]+datos[0].split(",")[0].split(":")[2]+datos[0].split(",")[0].split(":")[3];
            datos1[0]=datos1[0].substring(1,datos1[0].length()-1);
            datos1[1]=datos[0].split(",")[1].split(":")[1]+datos[0].split(",")[1].split(":")[2]+datos[0].split(",")[1].split(":")[3];
            datos1[1]=datos1[1].substring(1,datos1[1].length()-1);
            datos1[2]=datos[0].split(",")[2].split(":")[1];
            datos1[2]=datos1[2].substring(1,datos1[2].length()-1);
            return datos1;
        }
    }
    public static String[] MedecineList(String id) {
        RequestPackage AppointmentGet = new RequestPackage();
        AppointmentGet.setUri("http://localhost:8080/meditecserver/webapi/medicinelist?patientName="+id);
        AppointmentGet.setMethod("GET");
        String appointmentslist = HttpManager.getData(AppointmentGet);
        if (appointmentslist.substring(1, appointmentslist.length() - 2).equals("")) {
            String[] datos = new String [1];
            datos[0]="";
            return datos;
        }else{
            appointmentslist = appointmentslist.substring(2, appointmentslist.length()-2);
            System.out.println(appointmentslist);
            String datos[] = appointmentslist.split("}");
            for (int i = 0; i < datos.length; i++) {
                if(i!=0){
                    datos[i]=datos[i].substring(2,datos[i].length());
                }
            }
            return datos;
        }
    }
    public static String[] TestList(String id) {
        RequestPackage AppointmentGet = new RequestPackage();
        AppointmentGet.setUri("http://localhost:8080/meditecserver/webapi/medicaltestlist?patientName="+id);
        AppointmentGet.setMethod("GET");
        String appointmentslist = HttpManager.getData(AppointmentGet);
        if (appointmentslist.substring(1, appointmentslist.length() - 2).equals("")) {
            String[] datos = new String [1];
            datos[0]="";
            return datos;
        }else{
            appointmentslist = appointmentslist.substring(2, appointmentslist.length()-2);
            System.out.println(appointmentslist);
            String datos[] = appointmentslist.split("}");
            for (int i = 0; i < datos.length; i++) {
                if(i!=0){
                    datos[i]=datos[i].substring(2,datos[i].length());
                }
            }
            return datos;
        }
    }
    public static void Post(String[] atributes, String[] values, String url) {
        RequestPackage post = new RequestPackage();
        post.setUri(url);
        post.setMethod("POST");
        post.setMessageAttributes(atributes);
        post.setMessageValues(values);
        HttpManager.postData(post);
    }
}
