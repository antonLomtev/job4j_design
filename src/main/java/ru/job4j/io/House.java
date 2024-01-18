package ru.job4j.io;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "house")
@XmlAccessorType(XmlAccessType.FIELD)
public class House {
    @XmlAttribute
    private boolean isBrick;

    @XmlAttribute
    private int yearOfConstruction;

    @XmlAttribute
    private String company;

    @XmlElementWrapper(name = "entrances")
    @XmlElement(name = "entrance")
    private Integer[] entrance;
    private Address address;

    public House() {
    }

    public House(boolean isBrick, int yearOfConstruction, String company, Integer[] entrance, Address address) {
        this.isBrick = isBrick;
        this.yearOfConstruction = yearOfConstruction;
        this.company = company;
        this.entrance = entrance;
        this.address = address;
    }

    public boolean isBrick() {
        return isBrick;
    }

    public int getYearOfConstruction() {
        return yearOfConstruction;
    }

    public String getCompany() {
        return company;
    }

    public Integer[] getEntrance() {
        return entrance;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "House{"
                +
                "isBrick=" + isBrick
                +
                ", yearOfConstruction=" + yearOfConstruction
                + ", company='" + company + '\''
                + ", entrance=" + Arrays.toString(entrance)
                + ", address=" + address + '}';
    }

    public static void main(String[] args) throws JAXBException {
        final House house = new House(true, 1992, "Stabilnost",
                new Integer[]{1, 2, 3, 4, 5}, new Address("Kosmonavtov", 50));
        JAXBContext context = JAXBContext.newInstance(House.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(house, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
