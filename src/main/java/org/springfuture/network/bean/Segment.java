package org.springfuture.network.bean;

public class Segment {
    private final String segment;
    private final String mask;

    public Segment(String segment, String mask) {
        this.segment = segment;
        this.mask = mask;
    }

    public String getSegment() {
        return segment;
    }

    public String getMask() {
        return mask;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "segment='" + segment + '\'' +
                ", mask='" + mask + '\'' +
                '}';
    }
}
