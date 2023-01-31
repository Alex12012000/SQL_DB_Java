package model;

public class Computer {
    public int pcId;
    public String marca;
    public String ram;
    public String cpu;
    public Double schermo;
    public String gpu;
    public double prezzo;
    

    public Computer(String marca, String ram, String cpu, Double schermo, String gpu, double prezzo) {
        //this.pcId = pcId; è auto increment non serve
        this.marca = marca;
        this.ram = ram;
        this.cpu = cpu;
        this.schermo = schermo;
        this.gpu = gpu;
        this.prezzo = prezzo;
    }


    //setter e getter
    public int getPcId() {
        return this.pcId;
    }

    public void setPcId(int pcId) {
        this.pcId = pcId;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getRam() {
        return this.ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return this.cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public Double getSchermo() {
        return this.schermo;
    }

    public void setSchermo(Double schermo) {
        this.schermo = schermo;
    }

    public String getGpu() {
        return this.gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public double getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }


    @Override
    public String toString() {
            return 
                    "pcId : '" + getPcId() + "'\n " + 
                    "Marca: '" + getMarca() + "'\n " + 
                    "Ram: '" + getRam() + "'\n " + 
                    "Cpu: '" + getCpu() + "'\n " + 
                    "Schermo: '" + getSchermo() + "'\n" +
                    "Gpu: '" + getGpu() + "'\n " + 
                    "Prezzo: '" + getPrezzo() + "'\n "; 
     }


}