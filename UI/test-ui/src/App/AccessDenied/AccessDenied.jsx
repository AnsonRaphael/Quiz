import React from 'react';
import { useHistory } from 'react-router-dom';
import Button from '@material-ui/core/Button';
import Grid from '@material-ui/core/Grid';

function AccessDenied(props) {
    let history = useHistory();

    const onNavigateBack = () => {
        history.goBack();
    };

    return (
        <Grid container justify="center">
            <Grid item>
                Access Denied!!
            <br />
                <Button variant="contained" onClick={onNavigateBack}>Go Back</Button>
            </Grid>
        </Grid>
    );
}

export default AccessDenied;