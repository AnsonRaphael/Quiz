import { createMuiTheme } from "@material-ui/core/styles";

const SPACING = 8;
const COLOR_BLACK = "#242424";
const COLOR_WHITE = "#fff";
const COLOR_GRAY = "#d1d1d1";
const COLOR_TEXT_PRIMARY = "#8d8d8d";
const COLOR_PRIMARY_MAIN = "#9ABFFA";
const COLOR_SECONDARY_MAIN = "#6B85AF";
const BORDER_COLOR = "#e9e9e9";
const CAPTION_COLOR = '#bdc0c5';
const PERCENT_50 = "80";
const TRANSITION_DURATION_NORMAL = "0.3s";

const FONT_WEIGHT_LIGHT = 300;
const FONT_WEIGHT_SEMI_BOLD = 500;
const FONT_WEIGHT_BOLD = 700;

const spacing = (values, negativePxs = []) => {
    if (negativePxs.length > 0 && negativePxs.length !== values.length) {
        throw new Error("spacing arguments don't have same length");
    }
    const string = values.reduce((acc, curr, index) => {
        const px = negativePxs[index] || 0;
        return `${acc} ${curr * SPACING - px}px`;
    }, "");
    return string;
};

const Theme = createMuiTheme({
    spacing: SPACING,
    typography: {
        htmlFontSize: 10,
        fontSize: 12,
        h1: {
            fontSize: "5.4rem",
            lineHeight: spacing([7]),
            fontWeight: FONT_WEIGHT_SEMI_BOLD,
            color: COLOR_BLACK,
            marginBottom: spacing([2]),
        },
        h2: {
            fontSize: "4.4rem",
            lineHeight: spacing([7]),
            fontWeight: FONT_WEIGHT_SEMI_BOLD,
            marginBottom: spacing([1]),
        },
        h3: {
            fontSize: "2.4rem",
            lineHeight: spacing([3]),
            fontWeight: FONT_WEIGHT_SEMI_BOLD,
            color: COLOR_BLACK,
            marginBottom: spacing([2]),
        },
        h6: {
            fontSize: "2.2rem",
            lineHeight: spacing([3]),
            fontWeight: FONT_WEIGHT_BOLD,
            color: COLOR_BLACK,
            marginBottom: spacing([2]),
        },
        caption: {
            fontSize: "1.1rem",
            color: CAPTION_COLOR,
            lineHeight: spacing([3]),
            fontWeight: FONT_WEIGHT_LIGHT,
        },
        body1: {
            fontSize: "1.5rem",
            lineHeight: spacing([3]),
            fontWeight: FONT_WEIGHT_LIGHT,
        },
        body2: {
            fontSize: "1.2rem",
            lineHeight: spacing([2]),
            fontWeight: FONT_WEIGHT_LIGHT,
        },
    },
    palette: {
        common: {
            black: COLOR_BLACK,
        },
        primary: {
            main: COLOR_PRIMARY_MAIN,
            contrastText: COLOR_WHITE,
        },
        secondary: {
            main: COLOR_SECONDARY_MAIN,
        },
        text: {
            primary: COLOR_TEXT_PRIMARY,
        },
        divider: "#e9e9e9",
    },
    overrides: {
        MuiCssBaseline: {
            "@global": {
                html: {
                    fontSize: "62.5%",
                },
            },
        },

        MuiButton: {
            root: {
                fontSize: "1.4rem",
                textTransform: "none",
                borderRadius: `.4rem`,
                padding: spacing([1, 2]),
            },
            outlined: {
                padding: spacing([1, 2], [1, 1]),
            },
            contained: {
                boxShadow: "none",
            },
        },

        MuiFormControl: {
            root: {
                marginBottom: spacing([2]),
            },
        },

        MuiInputBase: {
            root: {
                color: COLOR_BLACK,
            },
            input: {
                height: spacing([1]),
                padding: spacing([2, 2]),
                fontWeight: FONT_WEIGHT_SEMI_BOLD,
                // backgroundColor: "#fff",
            },
        },

        MuiOutlinedInput: {
            root: {
                borderRadius: 0,
                "&:hover $notchedOutline": {
                    borderColor: `${COLOR_PRIMARY_MAIN}${PERCENT_50}`,
                },
                "&$focused": {
                    boxShadow: "0 5px 15px 0 rgba(0,0,0,.15)",
                },
                "&$focused $notchedOutline": {
                    borderWidth: 1,
                },
            },
            input: {
                padding: spacing([3.5, 3, 1.5]),
                "&:hover:not($disabled)": {
                    cursor: "pointer",
                },
            },
            notchedOutline: {
                borderColor: BORDER_COLOR,
                transition: TRANSITION_DURATION_NORMAL,
            },
        },

        MuiFormLabel: {
            root: {
                "&$error": {
                    color: COLOR_TEXT_PRIMARY,
                },
            },
        },

        MuiInputLabel: {
            outlined: {
                transform: `translate(${spacing([3], [1])}, ${spacing([2.5], [1])}) scale(1)`,

                "&$shrink": {
                    transform: `translate(${spacing([3], [1])}, ${spacing([1.5], [1])}) scale(0.8)`,
                },
            },
        },

        MuiFormHelperText: {
            root: {
                fontSize: "1.1rem",
                fontWeight: FONT_WEIGHT_SEMI_BOLD,
                lineHeight: "1.6rem",
                marginTop: spacing([0.5]),
            },
            contained: {
                marginLeft: spacing([3], [1]),
            },
        },

        MuiLink: {
            root: {
                color: COLOR_BLACK,
                transition: TRANSITION_DURATION_NORMAL,
                "&:hover": {
                    color: COLOR_PRIMARY_MAIN,
                },
            },
        },

        MuiStepper: {
            root: {
                padding: 0,
                overflow: "hidden",
            },
        },

        MuiStep: {
            horizontal: {
                flexGrow: 1,
                paddingLeft: 0,
                paddingRight: 0,
            },
        },

        MuiStepLabel: {
            root: {
                justifyContent: "center",
                paddingTop: spacing([2]),
                paddingBottom: spacing([2]),
            },
            label: {
                textTransform: "uppercase",
                justifyContent: "center",
                color: COLOR_GRAY,
                fontSize: "1.3rem",
                lineHeight: spacing([3]),
                fontWeight: FONT_WEIGHT_SEMI_BOLD,

                "&$active": {
                    fontWeight: FONT_WEIGHT_BOLD,
                    color: COLOR_BLACK,
                },
                "&$completed": {
                    fontWeight: FONT_WEIGHT_BOLD,
                    color: COLOR_BLACK,
                },
            },
            labelContainer: {
                width: "auto",
            }
        },

        MuiSelect: {
            selectMenu: {
                height: "auto",
                minHeight: 0,
                lineHeight: spacing([1]),
            },
        },
    },
});

export default Theme;
