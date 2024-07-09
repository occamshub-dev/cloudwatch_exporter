package io.prometheus.cloudwatch;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.cloudwatch.model.Dimension;
import software.amazon.awssdk.services.cloudwatch.model.Statistic;

interface DataGetter {
  MetricRuleData metricRuleDataFor(List<Dimension> dimensions);
  String getAccountForDimension(Dimension dimension);

  class MetricRuleData {
    Map<Statistic, Double> statisticValues;
    Map<String, Double> extendedValues;
    Instant timestamp;

    String unit;

    MetricRuleData(Instant timestamp, String unit) {
      this.timestamp = timestamp;
      this.unit = unit;
      this.statisticValues = new HashMap<>();
      this.extendedValues = new HashMap<>();
    }
  }
}
