package io.prometheus.cloudwatch;

import java.util.List;
import software.amazon.awssdk.services.cloudwatch.model.Dimension;

interface DimensionSource {

  DimensionData getDimensions(MetricRule rule, List<String> tagBasedResourceIds);

  class DimensionData {
    private final List<List<Dimension>> dimensions;
    private final List<String> accounts;

    DimensionData(List<List<Dimension>> dimensions, List<String> accounts) {
      this.dimensions = dimensions;
      this.accounts = accounts;
    }

    List<List<Dimension>> getDimensions() {
      return dimensions;
    }

    List<String> getAccounts() {
      return accounts;
    }
  }
}
