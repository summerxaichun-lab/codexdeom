"""Small math helpers used in unit tests."""


def add(a: int, b: int) -> int:
    """Return the sum of two integers."""
    return a + b


def is_even(value: int) -> bool:
    """Return True when the given integer is even."""
    return value % 2 == 0
