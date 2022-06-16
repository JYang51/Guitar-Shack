Feature: Check product needs re-ordering

  Scenario Outline: Product needs re-ordering
    Given stock level is greater than buffer
    When The product is purchased in a quantity that lowers the stock level to or below the buffer
    Then A notification is sent to the store manager to order more product

    Examples: of product sales
      | product | stock level | buffer | quantity | notification                                                                                     |
      | 811     | 37          | 20     | 17       | "Please order more of product 811: 'Epiphone Les Paul Classic In Worn Heritage Cherry Sunburst'" |

  Scenario Outline: Product doesn't need re-ordering
    Given stock level is greater than buffer
    When The product is purchased in a quantity that keeps the stock level above the buffer
    Then No notification is sent to the store manager

    Examples: of product sales
      | product | stock level | buffer | quantity | notification sent |
      | 811     | 37          | 20     | 16       | false             |

  Scenario Outline: Product is on order
    Given stock level is less than or equal to the buffer
    When The product is purchased
    Then No notification is sent to the store manager

    Examples: of product sales
      | product | stock level | buffer | quantity | notification sent |
      | 811     | 20          | 20     | 5        | false             |