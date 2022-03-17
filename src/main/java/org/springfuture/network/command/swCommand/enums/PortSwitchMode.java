package org.springfuture.network.command.swCommand.enums;

public enum PortSwitchMode {
    TRUNK("trunk"),
    ACCESS("access"),
    CISCO_ACCESS("access"),
    CISCO_TRUNK("trunk"),
    H3C_HYBRID("hybrid");

    private String mode;

    PortSwitchMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }
}
