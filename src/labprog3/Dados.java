package labprog3;

class Dados {
    private String codigo;
    private String latitude;
    private String longitude;
    private String data;
    private String descricao;

    public Dados() {
    }

    public Dados(String codigo) {
        this.codigo = codigo;
    }

    public Dados(String codigo,String latitude, String longitude, String data, String descricao) {
        super();
        this.codigo = codigo;
        this.latitude = latitude;
        this.longitude = longitude;
        this.data = data;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString(){
        return this.codigo;
    }
    
    
}
