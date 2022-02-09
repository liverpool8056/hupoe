package org.springfuture.network.command.swCommand.parser;

import org.springfuture.network.bean.Arp;
import org.springfuture.network.bean.MacEntry;
import org.springfuture.network.bean.Port;

import java.util.HashMap;
import java.util.List;

public interface PromptParser {

    Boolean error(String prompt);

    List<Arp> parseArpList(String prompt);

    List<MacEntry> parseMacTable(String prompt);

    String interfaceConfig(String prompt);

    HashMap<Integer, String> parseVlanNameMap(String prompt);

    HashMap<String, String> parseVlanDetail(String prompt);

    List<HashMap<String, String>> parseVlanInterfaceBrief(String prompt);

    List<Integer> parsePortGroupNums(String prompt);

    String parseManufacturer(String prompt);

    List<Port> parseGetPortStatus(String prompt);

    String parseGetMacOnPort(String prompt);

}
