import React from 'react';
import Grid from '@material-ui/core/Grid';
import { Box } from '@material-ui/core';
import WarningRoundedIcon from '@material-ui/icons/WarningRounded';
import Typography from '@material-ui/core/Typography';

import './PageNotFound.scss';

const PageNotFound = () => {
    return (
        <Grid container justify="center" className="page-not-found-wrapper">
            <Grid item xs={6} md={6}>
                <Box textAlign="center" m={9}>
                    <WarningRoundedIcon style={{ fontSize: 100 }} /> <br />
                    <Typography component="h2" variant="h4" color="inherit" gutterBottom>
                        <Box>404 Page Not Found</Box>
                    </Typography>
                </Box>
            </Grid>
        </Grid>
    );
}

export default PageNotFound;