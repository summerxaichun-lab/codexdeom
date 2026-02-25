"""Unit tests for math helpers."""

from codexdeom.math_utils import add, is_even


def test_add_positive_numbers() -> None:
    assert add(2, 3) == 5


def test_add_with_negative_number() -> None:
    assert add(7, -2) == 5


def test_is_even_for_even_number() -> None:
    assert is_even(10) is True


def test_is_even_for_odd_number() -> None:
    assert is_even(7) is False
